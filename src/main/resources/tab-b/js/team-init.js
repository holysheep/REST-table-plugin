jQuery(function () {
    var $table = AJS.$("#project-config-teams-table");

    function getResourceURL() {
        return contextPath + "/rest/teams/1.0/teams";
    }

    function getTeam(callback) {
        JIRA.SmartAjax.makeRequest({
            url: getResourceURL(),
            complete: function (xhr, status, response) {
                if (response.successful) {
                    callback(response.data.teams);
                } else {
                    $table.trigger("serverError",
                        [JIRA.SmartAjax.buildSimpleErrorContent(response)]);
                }
            }
        });
    }

    getTeam(function (teams) {
        window.ttt = teams;
        JIRA.Admin.TeamTable = new AJS.RestfulTable({
            el: $table,
            editable: true,
            allowReorder: true,
            loadingMsg: "Loading you table...",
            allowCreate: true,
            url: getResourceURL(),
            entries: teams, // is not being picked up by restfultable, hack below
            resources: {
                all: getResourceURL(),
                self: getResourceURL()
            },
            columns: [
                {
                    id: "name",
                    header: "Name"
                },
                {
                    id: "created",
                    header: "Created"
                }
            ],
            views: {
                editRow: JIRA.Admin.Team.EditTeamRow,
                row: JIRA.Admin.Team.TeamRow
            }
        });
        for (var i = 0; i < teams.length; i++) {
            JIRA.Admin.TeamTable.addRow(teams[i]);
        }
        JIRA.userhover($table);
    });
});
